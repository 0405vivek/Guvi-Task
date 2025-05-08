const display = document.getElementById("display");
const buttons = document.querySelectorAll("button");

let currentNumber = "";
let previousNumber = "";
let operation = null;

function updateDisplay() {
    display.value = currentNumber || previousNumber || "0";
}

function appendData(number) {
    if (number === "." && currentNumber.includes(".")) return; // Prevent multiple decimals
    currentNumber += number;
    updateDisplay();
}

function selectOperator(op) {
    if (currentNumber === "") return;

    if (previousNumber !== "") {
        calculate(); // Perform the calculation if an operation is already pending
    }

    previousNumber = currentNumber;
    operation = op;
    currentNumber = "";
}

function calculate() {
    if (currentNumber === "" || previousNumber === "") return;

    let prv = parseFloat(previousNumber);
    let cur = parseFloat(currentNumber);
    let result;

    switch (operation) {
        case "+":
            result = prv + cur;
            break;

        case "-":
            result = prv - cur;
            break;

        case "*":
            result = prv * cur;
            break;

        case "/":
            result = cur === 0 ? "Error" : prv / cur; // Handle division by zero
            break;

        default:
            return;
    }

    currentNumber = result.toString();
    previousNumber = "";
    operation = null;
    updateDisplay();
}

function clear() {
    currentNumber = "";
    previousNumber = "";
    operation = null;
    updateDisplay();
}

buttons.forEach((button) => {
    button.addEventListener("click", () => {
        let value = button.textContent;
        console.log(value);

        if (!isNaN(value) || value === ".") {
            appendData(value);
        } else if (value === "=") {
            calculate();
        } else if (value === "C") {
            clear();
        } else {
            selectOperator(value);
        }
    });
});
