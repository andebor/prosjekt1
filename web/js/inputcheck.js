//Sjekker epost opp mot reservasjonsdatabase
$("#email_input").keyup(function(e) {
    var email_input = $(this).val();
    $.post('check_email.php', {'email_input':email_input}, function(data) {
        $("#user-result").html(data);
        if(data == '<p class="bg-success">Det finnes reservasjoner på denne eposten.</p>') {
            $("#startdate").attr("disabled", false);
        }else{
            $("#startdate").attr("disabled", true);
            $("#submit").attr("disabled", true);
        }
    });
});

//Sjekker koie, startdate og enddate feltene for match i reservasjonsdatabasen ved ending av startdato hvis sluttdato er utfyllt.
$("#startdate").change(function() {
    var enddate = $("#enddate").val();
    var startdate = $(this).val();
    var koie = $("#select_koie").val();
    if (! $("#enddate").val() == '') {
        $.post('check_reservation.php', {'select_koie':koie, 'startdate':startdate, 'enddate':enddate}, function(data) {
        $("#reservation-display").html(data);
        if(data == '<p class="bg-success">Gyldig reservasjon.</p>') {
            $("#submit").attr("disabled", false);
        }else{
            $("#submit").attr("disabled", true);
        }
    });
    }else{
        $("#enddate").attr("disabled", false);
    }
    
});

//Sjekker koie, startdate og enddate feltene for match i reservasjonsdatabasen ved endring av sluttdato.
$("#enddate").change(function(e) {
    var enddate = $(this).val();
    var startdate = $("#startdate").val();
    var koie = $("#select_koie").val();
    console.log("koiename: " + koie);
    console.log("startdate: " + startdate);
    console.log("enddate: " + enddate);
    $.post('check_reservation.php', {'select_koie':koie, 'startdate':startdate, 'enddate':enddate}, function(data) {
        $("#reservation-display").html(data);
        if(data == '<p class="bg-success">Gyldig reservasjon.</p>') {
            $("#submit").attr("disabled", false);
        }else{
            $("#submit").attr("disabled", true);
        }
    });
});

//Sjekker koie, startdate og enddate feltene for match i reservasjonsdatabasen ved endring av koie feltet.
$("#select_koie").change(function() {
    var enddate = $("#enddate").val();
    var startdate = $("#startdate").val();
    var koie = $(this).val();
    if (! $("#enddate").val() == '') {
        $.post('check_reservation.php', {'select_koie':koie, 'startdate':startdate, 'enddate':enddate}, function(data) {
        $("#reservation-display").html(data);
        if(data == '<p class="bg-success">Gyldig reservasjon.</p>') {
            $("#submit").attr("disabled", false);
        }else{
            $("#submit").attr("disabled", true);
        }
    });
    }   
});
