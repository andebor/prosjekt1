<?php

include 'dbconn.php';

if(isset($_POST["select_koie"], $_POST["startdate"], $_POST["enddate"])) 
{
    $koie = ucfirst($_POST["select_koie"]);
    $koie = filter_var($koie, FILTER_SANITIZE_STRING, FILTER_FLAG_STRIP_LOW|FILTER_FLAG_STRIP_HIGH);
    
    $startdate = $_POST["startdate"];
    $startdate = filter_var($startdate, FILTER_SANITIZE_STRING, FILTER_FLAG_STRIP_LOW|FILTER_FLAG_STRIP_HIGH);

    $enddate = $_POST["enddate"];
    $enddate = filter_var($enddate, FILTER_SANITIZE_STRING, FILTER_FLAG_STRIP_LOW|FILTER_FLAG_STRIP_HIGH);

    $result = $mysqli->query("SELECT * FROM reservations WHERE koie_name= '" . $koie . "' AND startdate= '" . $startdate . "' AND enddate= '" . $enddate . "'");

    $reservation_exist = mysqli_num_rows($result);

    if($reservation_exist) {
        echo '<p class="bg-success">Gyldig reservasjon.</p>';
    }else{
        echo '<p class="bg-danger">Det finnes ingen reservasjon med den kombinasjonen</p>';
    }
}

?>
