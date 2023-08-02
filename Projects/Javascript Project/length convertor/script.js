function cmtoinches() {
    let cmval = Number(document.getElementById("input").value)
    let inchval = cmval / 2.54
    let result = document.getElementById("result")
    result.innerHTML = inchval.toFixed(2) + " inches"
}

function ctof() {
    let cmval = Number(document.getElementById("input").value)
    let inchval = cmval * (9 / 5) + 32;
    let result = document.getElementById("result")
    result.innerHTML = inchval.toFixed(2) + " fahrenheit"
}

function fd() {
    const months = Number(document.getElementById("input").value);
    let rate = 0;
    if (months < 3) {
        rate = 5.8;
    } else if (months >= 3 && months <= 6) {
        rate = 6.5;
    } else if (months >= 7 && months <= 9) {
        rate = 6.8;
    } else {
        rate = 7;
    }
    let result = document.querySelector('#result');
    result.innerHTML = "Yor insert rate is " + rate + "%"
}

function pal() {
    let palind = document.getElementById("input").value;
    let result = document.getElementById("result");
    if (palind === palind.split("").reverse().join("")) {
        result.innerHTML = "The Given String is Palindrome";
    } else {
        result.innerHTML = "The Given String is not Palindrome";
    }
}

function len() {
    let leng = document.getElementById("input").value;
    let result = document.getElementById("result");
    result.innerHTML = "The length of the String is " + leng.length;
}