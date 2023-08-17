let button = document.getElementById('btn');
let quote = document.getElementById('Quto');
let getQuote = () => {
    fetch(`https://api.quotable.io/random`)
        .then(res => res.json())
        .then(data => {
            quote.innerHTML = data.content;
        })
}
window.addEventListener("load", getQuote);
btn.addEventListener("click", getQuote);