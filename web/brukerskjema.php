<?php
$dbhost = 'mysql.stud.ntnu.no';
$dbuser = 'oyvbr_prosjekt1';
$dbpass = 'oyvbr_prosjekt1';
$dbname = 'oyvbr_koie';
$conn = mysql_connect($dbhost, $dbuser, $dbpass);
$db_found = mysql_select_db($dbname, $conn);
if(! $conn )
{
  die('Could not connect: ' . mysql_error());
}
if ($db_found) {

  if($_POST['submit'] == "Submit")
  {
    $koie = $_POST['select_koie'];
    $startdate = $_POST['startdate'];
    $enddate = $_POST['enddate'];
    $wood = $_POST['wood'];
    $smoke = $_POST['smoke'];
    $forgotten = $_POST['forgotten'];
    $missing = $_POST['missing'];
    if ($missing > 0) {
      $missingimploded = implode("`, `", $missing);
      $missingformatted = "`" . $missingimploded . "`";
    }
    $comment = $_POST['comment'];
    //foreach ($missing as $key => $value) {
      //mysql_query("UPDATE current_inventory SET $value = '0' WHERE koie = $koie;");
    //}
    
    $wood_query = mysql_query("UPDATE current_inventory SET wood = '$wood' WHERE koie = '$koie'");
    $smoke_query = mysql_query("UPDATE current_inventory SET smoke = '$smoke' WHERE koie = '$koie'");
    $new_report = "INSERT INTO reports (`koie_name`, `startdate`, `enddate`, `smoke_detector`, `wood`, `remarks_of_defects`, `forgotten`, `comments`) VALUES ('$koie', '$startdate', '$enddate', '$smoke', '$wood', '$missing', '$forgotten', '$comment')";
    $test = mysql_query($new_report, $conn);
    if (! $test) {
      die('Could not enter data: ' . mysql_error());
    }
  
  
  }
  //echo "Entered data successfully\n";
  //$comment_query = mysql_query("UPDATE current_inventory SET comment = '$comment' WHERE koie = '$koie'");
  //SET smoke = '$smoke' WHERE koie = '$koie'";

  //$sql = "INSERT INTO superkoie (inventartype,antall, maxAntall) VALUES ( "lysestake", 1, 1 )";
  //$result = mysql_query($sql);
}


//if($_POST['submit'] == "Submit")
//{
//  $errorMessage = "";


//}
mysql_close($conn);  
?>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Koierapport</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
<div id="container">

<form class="form-horizontal" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Koierapport</legend>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="select_koie">Velg koie</label>
  <div class="col-md-3">
    <select id="select_koie" name="select_koie" class="form-control">
      <option value="flåkoia">Flåkoia</option>
      <option value="fosenkoia">Fosenkoia</option>
      <option value="heinfjordstua">Heinfjordstua</option>
      <option value="hognabu">Hognabu</option>
      <option value="holmsåkoia">Holmsåkoia</option>
      <option value="holvassgamma">Holvassgamma</option>
      <option value="iglbu">Iglbu</option>
      <option value="kamtjønnkoia">Kamtjønnkoia</option>
      <option value="kråklikåten">Kråklikåten</option>
      <option value="kvernmovollen">Kvernmovollen</option>
      <option value="kåsen">Kåsen</option>
      <option value="lynhøgen">Lynhøgen</option>
      <option value="mortenskåten">Mortenskåten</option>
      <option value="nicokoia">Nicokoia</option>
      <option value="rindalsløa">Rindalsløa</option>
      <option value="selbukåten">Selbukåten</option>
      <option value="sonvasskoia">Sonvasskoia</option>
      <option value="stabburet">Stabburet</option>
      <option value="stakkslettbua">Stakkslettbua</option>
      <option value="telin">Telin</option>
      <option value="taagaabu">Taagaabu</option>
      <option value="vekvessætra">Vekvessætra</option>
      <option value="øvensenget">Øvensenget</option>
    </select>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="startdate">Dato - fra:</label>
  <div class="col-md-3">
    <input type='date' class="form-control" name="startdate" id="startdate" />  
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="enddate">Dato - til:</label>
  <div class="col-md-3">
    <input type='date' class="form-control" name="enddate" id="enddate" />  
  </div>
</div>

<!-- Multiple Radios (inline) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="wood">Antall vedstokker ved koia </label>
  <div class="col-md-4"> 
    <label class="radio-inline" for="wood-0">
      <input type="radio" name="wood" id="wood-0" value="1" checked="checked">
      0-15
    </label> 
    <label class="radio-inline" for="wood-1">
      <input type="radio" name="wood" id="wood-1" value="2">
      15-30
    </label> 
    <label class="radio-inline" for="wood-2">
      <input type="radio" name="wood" id="wood-2" value="3">
      &gt;30
    </label>
  </div>
</div>

<!-- Multiple Radios (inline) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="smoke">Virket røykvarsler?</label>
  <div class="col-md-4"> 
    <label class="radio-inline" for="smoke-0">
      <input type="radio" name="smoke" id="smoke-0" value="1" checked="checked">
      JA
    </label> 
    <label class="radio-inline" for="smoke-1">
      <input type="radio" name="smoke" id="smoke-1" value="2">
      NEI
    </label>
  </div>
</div>

<!-- Multiple Radios (inline) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="smoke">Glemte dere noe?</label>
  <div class="col-md-4"> 
    <label class="radio-inline" for="forgotten-0">
      <input type="radio" name="forgotten" id="smoke-0" value="1">
      JA
    </label> 
    <label class="radio-inline" for="forgotten-1">
      <input type="radio" name="forgotten" id="smoke-1" value="2" checked="checked">
      NEI
    </label>
  </div>
</div>

<!-- Select Multiple -->
<div class="form-group">
  <label class="col-md-4 control-label" for="missing">Manglet noe</label>
  <div class="col-md-3">
    <select id="missing" name="missing[]" class="form-control" multiple="multiple">
      <option value="primus">Primus m/bruksanvisning</option>
      <option value="øks">Øks</option>
      <option value="sag">Sag</option>
      <option value="sagkrakk">Sagkrakk</option>
      <option value="spade">Spade</option>
      <option value="parafinlampe">Parafinlampe</option>
      <option value="vaskemiddel">Vaskemiddel</option>
      <option value="oppvaskkost">Oppvaskkost</option>
      <option value="kjøkkenklut">Kjøkkenklut</option>
      <option value="kopphåndkle">Kopphåndkle</option>
      <option value="bestikk">Bestikk</option>
      <option value="tallerkener">Tallerkener</option>
      <option value="stekepanne">Stekepanne</option>
      <option value="gryter">Gryter</option>
      <option value="hjulvisp">Hjulvisp</option>
      <option value="koiebok">Koiebok(hyttebok)</option>
      <option value="hammer">Hammer</option>
      <option value="tommestokk">Tommestokk</option>
      <option value="brannteppe">Brannteppe</option>
      <option value="brannapparat">Brannslukningsapparat</option>
      <option value="lysestaker">Stødige lysestaker</option>
    </select>
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="comment">Kommentar:</label>
  <div class="col-md-3">                     
    <textarea class="form-control" id="comment" name="comment"></textarea>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4">
    <button type="submit" id="submit" name="submit" value="Submit" class="btn btn-primary">Send!</button>
    <?php 
    printf($koie . " - " . $wood . " - " .$smoke . " - ");
    print_r($missing);

    //echo $missing[5];
    ?>
  </div>
</div>

</fieldset>
</form>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</div>
  </body>
</html>