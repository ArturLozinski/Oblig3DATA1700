let ticketArray = [];

function buyTicket() {

    let movie = document.getElementById("movieSelect").value;
    let numberOfTickets = document.getElementById("number").value;
    let fname = document.getElementById("fname").value;
    let lname = document.getElementById("lname").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let errorMessage = false;

    if (movie === "0") {
        document.getElementById("invalidChoice").innerHTML = "Please select a movie";
        errorMessage = true;
    }

    if (numberOfTickets === null || numberOfTickets <= 0) {
        document.getElementById("invalidNumber").innerHTML = "Please enter a valid amount of tickets";
        errorMessage = true;
    }
    // The following if-statements refer to the regex functions defined further below.
    if (!validFirstName(fname)) {
        document.getElementById("invalidFirstName").innerHTML = "Please fill out your first name, 3-20 alphabetical characters";
        errorMessage = true;
    }

    if (!validLastName(lname)) {
        document.getElementById("invalidLastName").innerHTML = "Please fill out your last name, 3-20 alphabetical characters";
        errorMessage = true;
    }

    if (!validEmail(email)) {
        document.getElementById("invalidEmail").innerHTML = "Please enter a valid email adress";
        errorMessage = true;
    }

    if (!validPhone(phone)) {
        document.getElementById("invalidPhone").innerHTML = "Please enter a valid phone number";
        errorMessage = true;
    }
    // If all the validations above pass, the input gets set
    if (!errorMessage) {
        let ticketInput = {
            movie: movie,
            numberOfTickets: numberOfTickets,
            fname: fname,
            lname: lname,
            email: email,
            phone: phone
        }
        $.post("/save", ticketInput, function () {
            getAll()
        });
        $.ajax({
            url: '/save',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(ticketInput),
            success: function () {
                // On success, clear the input fields and error messages
                clearInput();
                clearErrorMessages();
                // And update the ticket table
                displayTicketTable();
            },
            error: function (error) {
                // handle error
                console.log('Error: ', error);
            }
        });
    }
}

// regex for name validation seemed imperative
function validFirstName(fname) {
    let re = /^([a-zæøåA-ZÆØÅ]{3,20})$/;
    return re.test(fname);
}

function validLastName(lname) {
    let re = /^([a-zæøåA-ZÆØÅ]{3,20})$/;
    return re.test(lname);
}

// Email validation function
// Checked with regexr.com
function validEmail(email) {
    let re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3})|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

// Phone validation function that can also start with a + sign for country code and an international standard maximum of 15 characters.
// Checked with regexr.com
function validPhone(phone) {
    let re = /^\+?[0-9]{8,15}$/; // Sourced from https://www.oreilly.com/library/view/regular-expressions-cookbook/9781449327453/ch04s03.html
    return re.test(phone);
}

function getAll() {
    $.get("/getAll", function (Tickets) {
        displayTicketTable(Tickets);
    });
}

function clearInput() {
    document.getElementById("movieSelect").value = "0";
    document.getElementById("number").value = "";
    document.getElementById("fname").value = "";
    document.getElementById("lname").value = "";
    document.getElementById("email").value = "";
    document.getElementById("phone").value = "";
}


function displayTicketTable(ticket) {
    let out = "<table class='table table-striped'><tr>" + "<th>ID</th>" +
        "<th>Movie</th><th>Tickets</th><th>First name</th><th>Last name</th><th>E-Mail</th><th>Phonenumber</th>" +
        "</tr>";
    for (let p of ticket) {
        out += "<tr>";
        out += "<td>" + p.id + "</td>" +
            "<td>" + p.movie + "</td>" +
            "<td>" + p.numberOfTickets + "</td>" +
            "<td>" + p.fname + "</td>" +
            "<td>" + p.lname + "</td>" +
            "<td>" + p.email + "</td>" +
            "<td>" + p.phone + "</td>";
        out += "</tr>";
    }
    clearErrorMessages();
    clearInput();
    console.log(out)
    document.getElementById("ticketTable").innerHTML = out;
}

function clearErrorMessages() {
    document.getElementById("invalidChoice").innerHTML = "";
    document.getElementById("invalidNumber").innerHTML = "";
    document.getElementById("invalidFirstName").innerHTML = "";
    document.getElementById("invalidLastName").innerHTML = "";
    document.getElementById("invalidEmail").innerHTML = "";
    document.getElementById("invalidPhone").innerHTML = "";
}

function deleteAllTickets() {
    $.ajax({
        url: "/deleteAll",
        type: "DELETE",
        success: function () {
            $("#ticketTable").html("");
            $("#movie").val("");
            $("#numberOfTickets").val("");
            $("#fname").val("");
            $("#lname").val("");
            $("#email").val("");
            $("#phone").val("");
        }
    });
}