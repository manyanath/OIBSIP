function convertTemp() {

    let temp = parseFloat(document.getElementById("temp").value);
    let unit = document.getElementById("unit").value;
    let result = document.getElementById("result");

    if (isNaN(temp)) {
        result.innerHTML = "⚠ Please enter a valid number.";
        return;
    }

    if (unit === "c" && temp < -273.15) {
        result.innerHTML = "⚠ Temperature cannot be below absolute zero (-273.15°C).";
        return;
    }

    if (unit === "f" && temp < -459.67) {
        result.innerHTML = "⚠ Temperature cannot be below absolute zero (-459.67°F).";
        return;
    }

    if (unit === "k" && temp < 0) {
        result.innerHTML = "⚠ Temperature cannot be below 0 Kelvin.";
        return;
    }

    let c, f, k;

    if (unit === "c") {
        c = temp;
        f = (temp * 9/5) + 32;
        k = temp + 273.15;
    }

    else if (unit === "f") {
        c = (temp - 32) * 5/9;
        f = temp;
        k = c + 273.15;
    }

    else {
        k = temp;
        c = temp - 273.15;
        f = (c * 9/5) + 32;
    }

    result.innerHTML =
        `Celsius: ${c.toFixed(2)} °C <br>
         Fahrenheit: ${f.toFixed(2)} °F <br>
         Kelvin: ${k.toFixed(2)} K`;
}function convertTemp() {

    let temp = parseFloat(document.getElementById("temp").value);
    let unit = document.getElementById("unit").value;
    let result = document.getElementById("result");

    if (isNaN(temp)) {
        result.innerHTML = "⚠ Please enter a valid number.";
        return;
    }

    if (unit === "c" && temp < -273.15) {
        result.innerHTML = "⚠ Temperature cannot be below absolute zero (-273.15°C).";
        return;
    }

    if (unit === "f" && temp < -459.67) {
        result.innerHTML = "⚠ Temperature cannot be below absolute zero (-459.67°F).";
        return;
    }

    if (unit === "k" && temp < 0) {
        result.innerHTML = "⚠ Temperature cannot be below 0 Kelvin.";
        return;
    }

    let c, f, k;

    if (unit === "c") {
        c = temp;
        f = (temp * 9/5) + 32;
        k = temp + 273.15;
    }

    else if (unit === "f") {
        c = (temp - 32) * 5/9;
        f = temp;
        k = c + 273.15;
    }

    else {
        k = temp;
        c = temp - 273.15;
        f = (c * 9/5) + 32;
    }

    result.innerHTML =
        `Celsius: ${c.toFixed(2)} °C <br>
         Fahrenheit: ${f.toFixed(2)} °F <br>
         Kelvin: ${k.toFixed(2)} K`;
}
