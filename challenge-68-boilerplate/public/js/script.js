const httpRequest = new XMLHttpRequest()
httpRequest.open('GET', 'http://localhost:3000/moviesList')
httpRequest.send()
httpRequest.onreadystatechange = () => {
    respo = JSON.parse(httpRequest.response)
    let colHTML = ''
    let tableBody = ''

    respo.forEach(element => {
        colHTML += `<div class="col-6 col-sm-4 col-md-3 col-lg-2 py-4"><div class="card"><img src="./${element.posterPath}" alt="${element.title}" class="card-img-top"><div class="card-body"><h5 class="card-title">${element.title}</h5></div></div></div>`
        tableBody +=`<tr><th>${element.id}</th><td>${element.title}</td><td>${element.posterPath}</td></tr>`
    })
    document.getElementById('movies-list').innerHTML = colHTML
    document.getElementById('table-body').innerHTML = tableBody
}