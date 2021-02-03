const list = document.querySelector('#book-list ul')
list.addEventListener('click', e => {
  const li = e.target.parentElement
  list.removeChild(li)
})

