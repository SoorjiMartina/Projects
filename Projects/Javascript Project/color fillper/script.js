let col = document.getElementById("color");
let ro = document.getElementById("wrap");
let btn = document.getElementById("btn");
const hex = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F']
btn.addEventListener('click', function() {
    let hexColor = "#"
    for (let i = 0; i < 6; i++) {
        hexColor += randomvalue();
    }
    ro.style.backgroundColor = hexColor
    col.innerHTML = hexColor
})

function randomvalue() {
    let randindex = Math.floor(Math.random() * 16)
    return hex[randindex]
}