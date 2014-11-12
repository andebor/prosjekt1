<?php
// Oppretter en tilkobling til databasen

$dbhost = 'mysql.stud.ntnu.no';
$dbuser = 'oyvbr_prosjekt1';
$dbpass = 'oyvbr_prosjekt1';
$dbname = 'oyvbr_koie';

$mysqli = new mysqli($dbhost, $dbuser, $dbpass, $dbname);
if ($mysqli->connect_errno) {
    echo "Failed to connect to MySQL: (" . $mysqli->connect_errno . ") " . $mysqli->connect_error;
}

?>