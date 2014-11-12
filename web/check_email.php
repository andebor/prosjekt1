<?php

include 'dbconn.php';

//Sjekker om det finnes en reservasjon på angitt epost
if(isset($_POST["email_input"]))
{    
    $email_input =  strtolower(trim($_POST["email_input"])); 
    
    $email_input = filter_var($email_input, FILTER_SANITIZE_STRING, FILTER_FLAG_STRIP_LOW|FILTER_FLAG_STRIP_HIGH);
    
    $results = $mysqli->query("SELECT tenant_email FROM reservations WHERE tenant_email='$email_input'");
    
    $username_exist = mysqli_num_rows($results); 
    
    if($username_exist) {
        echo '<p class="bg-success">Det finnes reservasjoner på denne eposten.</p>';
    }else{
        echo '<p class="bg-danger">Det finnes ingen reservasjon på denne eposten.</p>';
    }
}

?>