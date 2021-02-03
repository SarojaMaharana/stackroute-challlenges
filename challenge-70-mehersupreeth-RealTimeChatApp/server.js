const http = require('http')
const express = require('express')
const path = require('path')
const socketIO = require('socket.io')
const formatMessage = require('./utils/messages')
const {userJoin, getCurrentUser, userLeave, getChannelUsers} = require('./utils/users')

const PORT = 3000
const botName = 'Admin'

const app = express()
const server = http.createServer(app)
const io = socketIO(server)

// Run when client connects
io.on('connection', socket => {
    socket.on('joinRoom', data => {
        const user = userJoin(socket.id, data.uname, data.cname)
        socket.join(user.channelName)
        //Welcome the current user
        socket.emit('message', formatMessage(botName, 'Welcome...'))
    
        //Broadcast when a user connects
        socket.broadcast.to(user.channelName).emit('message', formatMessage(botName, `${data.uname} has joined the chat`))

        // Send users and room info
        io.to(user.channelName).emit('channelUsers', {
            channel: user.channelName,
            users: getChannelUsers(user.channelName)
        })
    })

    // Listen for chat message
    socket.on('chatMessage', (msg) => {
        const user = getCurrentUser(socket.id)
        io.to(user.channelName).emit('message', formatMessage(user.username, msg))
    })

    // Runs when client disconnects
    socket.on('disconnect', () => {
        const user = userLeave(socket.id)
        if(user){
            io.to(user.channelName).emit('message', formatMessage(botName, `${user.username} has left the chat`))
            // Send users and room info
            io.to(user.channelName).emit('channelUsers', {
                channel: user.channelName,
                users: getChannelUsers(user.channelName)
            })
        }
    })
})

// Set static folders
app.use(express.static(path.join(__dirname, 'public')))
app.use(express.static(path.join(__dirname, 'node_modules')))

server.listen(PORT, () => console.log(`Server is running on the port ${PORT}`))