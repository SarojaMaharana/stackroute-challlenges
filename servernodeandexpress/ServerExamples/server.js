//1. Build my own server
//import libraries
var http = require('http')
//2. Create server - returns a server object
const server = http.createServer(function(request,response){
    //header information -> text/javascript, json
    response.writeHead(200,{
        "content-type":"text/plain"
    })

    response.end("Hello !!!")
})
//3. make the server listen for clients

//event emitter model 
//server -> emits a listen event, port no etc

server.listen('3000',()=>{console.log("Server is ready and listening at port 3000")})

//capture the error

server.on('error',(error)=>{
    if(error.code === 'EADRINUSE')
    {
        console.log('Port already in use')
    }
})
