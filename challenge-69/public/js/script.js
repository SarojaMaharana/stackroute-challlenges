function getMovies() {
	fetch('http://localhost:3000/movies')
	.then( response => {
		if(response.status == 200)
			return response.json()
	}).then(movies => {
		let tbodyHTML = ''
		movies.forEach(movie => {
			tbodyHTML += `<tr>
			<th>${movie.id}</th>
			<td>${movie.title}</td>
			<td>${movie.posterPath}</td>
			</tr>`
		})
		document.getElementsByTagName('tbody')[0].innerHTML = tbodyHTML
	})
}

function getFavourites() {
	fetch('http://localhost:3000/favourites')
	.then( response => {
		if(response.status == 200)
			return response.json()
	}).then(favourites => {
		let tbodyHTML = ''
		favourites.forEach(favourite => {
			tbodyHTML += `<tr>
			<th>${favourite.id}</th>
			<td>${favourite.title}</td>
			<td>${favourite.posterPath}</td>
			</tr>`
		})
		document.getElementsByTagName('tbody')[1].innerHTML = tbodyHTML
	})
}

function addFavourite() {

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


