let button = document.getElementById('add');
let todoList = document.getElementById('TodoList');
let input = document.getElementById('input');
let todos = [];
window.onload = () => {
    todos = JSON.parse(localStorage.getItem('todos')) || []
    todos.forEach(todo => addtodo(todo))
}
button.addEventListener('click', () => {
    todos.push(input.value)
    localStorage.setItem('todos', JSON.stringify(todos))
    addtodo(input.value)
    input.value = ''
})

function addtodo(todo) {
    let par = document.createElement('p')
    par.innerHTML = todo
    todoList.appendChild(par)


    par.addEventListener('click', () => {
        par.style.textDecoration = 'line-through';
        remove(todo)

    })
    par.addEventListener('dblclick', () => {
        todoList.removeChild(par)
        remove(todo)
    })
}

function remove(todo) {
    let index = todos.indexOf(todo)
    if (index > -1)
        todos.splice(index, 1)
    localStorage.setItem('todos', JSON.stringify(todos))
}