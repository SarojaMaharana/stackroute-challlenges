function getMovies() {
    fetch('http://localhost:3000/movies')
	.then( response => {
		if(response.status == 200)
			return response.json()
	}).then(movies => {
		let toAdd = ''
		movies.forEach(movie => {
			toAdd += `<div class="col-6 col-sm-4 col-md-3 col-lg-3 py-4">
			<div class="card bg-dark text-white">
				<img class="card-img" src="${movie.posterPath}" alt="Card image">
				<div class="card-img-overlay d-flex flex-column">
					<div class="row">
						<div class="col-8">
							<h5 class="card-title">Title</h5>
						</div>
						<div class="col-4 text-right">`
						if(movie.favourite === 'true'){
							toAdd += `<a href="#" class="fas fa-heart" style="color: #ff3d49;" onclick="addFavourite(${movie.id})"></a>`
						}
						else {
							toAdd += `<a href="#" class="fas fa-heart" onclick="addFavourite(${movie.id})"></a>`
						}
			toAdd +=    `</div>
					</div>
					<h3 class="card-text font-weight-bold"><span class="mr-auto">${movie.title}</span></h3>
					<div class="mt-auto">
						<div class="row">
							<div class="col-6 text-left">
								<a onclick="getMovieById(${movie.id})" class="fas fa-pencil-alt" data-toggle="modal" data-target="#editMovie"></a>
							</div>
							<div class="col-6 text-right dropright">
								<a class="fas fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
								<div class="dropdown-menu">
									<a class="text-dark px-3" onclick="deleteMovie(${movie.id})">Delete</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>`
		})
		document.getElementById('movies-list').innerHTML = toAdd
	})
}

document.getElementById('add-movie').addEventListener('click', e => {
	var movieName = document.getElementById('add-movie-name').value
	var posterPath = document.getElementById('poster-path').value
	var newMovie = {
		'title' : movieName,
		'posterPath' : posterPath,
		'favourite': 'false'
	}
	fetch('http://localhost:3000/movies', {
		'method' : 'POST',
		'headers' : {
			'Content-type':'application/json'
		},
		'body' : JSON.stringify(newMovie)
	})
	.then(response => {
		if(response.status === 201){
			document.querySelector('#add-movie-name').value = ""
			document.querySelector('#poster-path').value = ""
			$('#addMovie').modal('hide')
			getMovies()
		}
	})
	.catch(error => {
		console.log(error)
		alert(error)
	})
})

function getMovieById(id) {
	fetch(`http://localhost:3000/movies/${id}`)
	.then(response => {
		if(response.status === 200){
			return response.json()
		}
	})
	.then(movie => {
		document.getElementById('movie-id').value = movie.id
		document.getElementById('edit-movie-name').value = movie.title
		document.getElementById('edit-poster-path').value = movie.posterPath
	})
	.catch(error => {
		console.log(error)
		alert(error)
	})
}

document.getElementById('edit-movie').addEventListener('click', e => {
	var movieId = document.getElementById('movie-id').value
	var movieName = document.getElementById('edit-movie-name').value
	var posterPath = document.getElementById('edit-poster-path').value
	fetch(`http://localhost:3000/movies/${movieId}`, {
		'method' : 'PUT',
		'headers' : {
			'Content-type':'application/json'
		},
		'body' : JSON.stringify({
			'title' : movieName,
			'posterPath' : posterPath,
			'favourite' : 'false'
		})
	})
	.then(response => {
		if(response.status === 200){
			$('#editMovie').modal('hide')
			getMovies()
		}
	})
	.catch(error => {
		console.log(error)
		alert(error)
	})
})

function deleteMovie(id) {
	fetch(`http://localhost:3000/movies/${id}`, {
		'method' : 'DELETE'
	})
	.then(response => {
		if(response.status === 200){
			//deleting the record in favorites also if present
			fetch(`http://localhost:3000/favorites/${id}`)
			.then(response => {
				if(response.status == 200){
					fetch(`http://localhost:3000/favorites/${id}`, {
						'method' : 'DELETE'
					})
					.then(response => {
						console.log('is there in favourite')
						if(response.status == 200){
							alert('record deleted')
							getMovies()
						}
						// getFavourites()
					}).catch((error)=>{
						console.log(error)
					})
				}
			}).catch((error)=>{
				console.log(error)
			})
        }
	}).catch((error)=>{
        console.log(error)
    })
}

function getFavourites() {
	fetch('http://localhost:3000/favourites')
	.then( response => {
		if(response.status == 200)
			return response.json()
	}).then(movies => {
		let toAdd = ''
		movies.forEach(movie => {
			toAdd += `<div class="col-6 col-sm-4 col-md-3 col-lg-3 py-4">
			<div class="card bg-dark text-white">
				<img class="card-img" src="${movie.posterPath}" alt="Card image">
				<div class="card-img-overlay d-flex flex-column">
					<div class="row">
						<div class="col-8">
							<h5 class="card-title">Title</h5>
						</div>
						<div class="col-4 text-right">
							<a href="#" class="fas fa-heart" style="color: #ff3d49;"></a>
						</div>
					</div>
					<h3 class="card-text font-weight-bold"><span class="mr-auto">${movie.title}</span></h3>
					<div class="mt-auto">
						<div class="row">
							<div class="col-6 text-left">
								<a onclick="getMovieById(${movie.id})" class="fas fa-pencil-alt" data-toggle="modal" data-target="#editMovie"></a>
							</div>
							<div class="col-6 text-right dropright">
								<a class="fas fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
								<div class="dropdown-menu">
									<a class="text-dark px-3" onclick="deleteMovie(${movie.id})">Delete</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>`
		})
		document.getElementById('favourite-list').innerHTML = toAdd
	})
}

function addFavourite(movieId) {
	fetch(`http://localhost:3000/movies/${movieId}`)
	.then(response => {
		if(response.status == 200){
			return response.json()
		}
	}).then(favourite => {
		var newID = favourite.id
		var newName = favourite.title
		var newPosterPath = favourite.posterPath

		fetch(`http://localhost:3000/favourites/${newID}`)
		.then(response => {
			if(response.status == 200){
				//deleting this item in favorites
				fetch(`http://localhost:3000/favourites/${newID}`, {
					'method' : 'DELETE'
				})
				.then(response => {
					console.log('deleted in favorites')
					if(response.status === 200){
						//changing the favourite to false
						fetch(`http://localhost:3000/movies/${newID}`, {
							'method' : 'PUT',
							'headers' : {
								'Content-type':'application/json'
							},
							'body' : JSON.stringify({
								'title' : newName,
								'posterPath' : newPosterPath,
								'favourite' : 'false'
							})
						})
						.then(response => {
							if(response.status === 200){
								console.log('edited in movies')
								getMovies()
							}
						})
						.catch(error => {
							console.log(error)
							alert(error)
						})
					}
				}).catch((error)=>{
					console.log(error)
				})
				// alert(`${newName} is already present`)
			}
			else {
				fetch('http://localhost:3000/favourites', {
					'method' : 'POST',
					'headers' : {
						'Content-type':'application/json'
					},
					'body' : JSON.stringify({
						"id" : newID,
						"title" : newName,
						"posterPath" : newPosterPath,
						"favourite" : "true"
					})
				})
				.then(response => {
					if(response.status == 201){
						//changing the favourite value in movies also
						fetch(`http://localhost:3000/movies/${newID}`, {
							'method' : 'PUT',
							'headers' : {
								'Content-type':'application/json'
							},
							'body' : JSON.stringify({
								"title" : newName,
								"posterPath" : newPosterPath,
								"favourite" : "true"
							})
						}).then(response => {
							if(response.status === 200){
								console.log('Movie is added to favourites')
								getMovies()
							}
						})
						.catch(error => {
							console.log(error)
							alert(error)
						})
					}
				}).catch(error => {
					console.log(error)
					alert(error)
				})
			}
		}).catch(error => {
			console.log(error)
			alert(error)
		})
	}).catch(error => {
		console.log(error)
		alert(error)
	})
}

module.exports = {
	getMovies,
	getFavourites,
	addFavourite
};

// You will get error - Uncaught ReferenceError: module is not defined
// while running this script on browser which you shall ignore
// as this is required for testing purposes and shall not hinder
// it's normal execution


