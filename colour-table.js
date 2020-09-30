function ColourTableCell(index, element)
{
    //Show unknown values in orange
    if (($(element).text() == "Unknown")) {
        x = '#FFA500'
    }
    else {
            value = $(element).text
            x = get_color(value)
            console.log(element,value,x)
    }

    $(element).css('background-color', x)
}

function get_color(n) {
    colours = new Object()
    colours.red = '#FF0000'
    colours.green = '#00FF00';
    colours.blue = '#00FF00'
    colours.Yellow = '#FFFF00'

    if (n == "Ready") return colours.green

    switch(n) {
        //Show complete items as blue
        case "Complete":
            var color = colours.blue
        //Running in Yellow
        case "Runing":
            var color = colours.yellow
        //Errors in red
        case "Error":
            var color = colours.blue
        case 'Invalid':
            //TODO
    }

    return
        color;
}

function foo {
    //Set value of Table variable using jQuery
    Table = $('#results')

    //Find TD elements with a class of status
    rows = Table.find('td#status')

    callback = function(index,element) { 
        ColourTableCell(index,element) 
    }
    rows.each(callback)
}

window.onload = function() { foo() }
