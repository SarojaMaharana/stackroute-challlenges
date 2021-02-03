const express = require('express')
const app = express()
const impportDB = require('./db.json')
const categoriesDB = require('./categories.json')
const categoryPlaylistsDB = require('./categoryPlaylists.json')
const featuredPlayListsDB = require('./featuredPlaylists.json')
const newReleasesDB = require('./newReleases.json')

let port = process.env.PORT || 3000

app.use((req, res, next) => {
    res.header("Access-Control-Allow-Origin", "http://localhost:4200"); // update to match the domain you will make the request from
    res.header("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next();
})

app.get("/", (req, res) => {
    // res.send("Welcome to Music Api")
    res.send(impportDB)
})

app.get("/categories", (req, res) => {
    res.send(categoriesDB)
})

app.get("/categoryPlaylists", (req, res) => {
    res.send(categoryPlaylistsDB)
})

app.get("/featuredPlayLists", (req, res) => {
    res.send(featuredPlayListsDB)
})

app.get("/newReleases", (req, res) => {
    res.send(newReleasesDB)
})

app.listen(port, () => {
    console.log(`Listening on port http://localhost:${port}`)
})