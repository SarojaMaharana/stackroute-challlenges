const chatForm = document.getElementById('mca_form')
const chatMessages = document.getElementById('messages_entry_point')
const socket = io()

// Get Username and channel from url
var queryString = window.location.search
var urlParmsArr = new URLSearchParams(queryString)
const username = urlParmsArr.get('username')
document.getElementById('user-name').textContent = username
const channelName = urlParmsArr.get('channelName')

// Join chat room
socket.emit('joinRoom', {uname: username, cname: channelName})

// Get channel and users
socket.on('channelUsers', ({channel, users}) => {
    outputChannelName(channel)
    outputUsers(users)
})

// Message from Server
socket.on('message', message => {
    console.log(message)
    outputMessage(message)
})

// Message Submit
chatForm.addEventListener('submit', event => {
    event.preventDefault()
    const msg = event.target.elements.msg.value
    // emit message to the server
    socket.emit('chatMessage', msg)
    // clear the value in the message after submit
    event.target.elements.msg.value = ''
})

// Output Message to DOM
function outputMessage(message) {
    const li = document.createElement('li')
    li.innerHTML = `<span>${message.username}, ${message.time}: <span>${message.text}</span></span>`
    document.getElementById('messages_entry_point').appendChild(li)
}

// Add Channel Name to DOM
function outputChannelName(channel) {
    // do the dom manipulation by getting the ID
}

// Add Users to DOM
function outputUsers(users) {
    // getElementById().innerHTML = `${users.map(user => `<li>${user.username}</li>`).join('')}`
}