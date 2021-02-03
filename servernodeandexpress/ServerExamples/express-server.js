const http = require('http')
const express = require('express')

//web framework for express

const app = express()

//html files, css ...static .... tell so that it can handle the events , dom manipulation etc...

const path = require('path')

app.use(express.static(path.join(__dirname,'public')))

const server = http.createServer(app)

server.listen('3010',()=>{
    console.log('Express started at 3010')
})




