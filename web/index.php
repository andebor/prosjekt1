<?php
include 'functions.php';
include 'dbconn.php';

// set utf-8
$mysqli->set_charset("utf8");

//Henter liste over utstyr som kan meldes som mangel
$inventory_list = $mysqli->query("SELECT utstyr FROM `current_inventory2` WHERE utstyr <> 'wood' AND utstyr <> 'smoke' AND utstyr <> 'status' ORDER BY utstyr");

if($_POST['submit'] == "Submit")
{
  // Lager variabler fra form submit
  $koie = $_POST['select_koie'];
  $startdate = $_POST['startdate'];
  $enddate = $_POST['enddate'];
  $wood = $_POST['wood'];
  $smoke = $_POST['smoke'];
  $forgotten = $_POST['forgotten'];
  $missing = $_POST['missing'];
  $comment = $_POST['comment'];
  if (count($missing) > 0) {
      $impMissing = implode(", ", $missing);
      $impMissing = ucwords($impMissing);
  }
  
  $status = findStatus($missing, $forgotten);

  $double_query = createUpdate($missing, $koie, $wood, $smoke, $status);

  $double_query .= "INSERT INTO reports (`koie_name`, `status`, `startdate`, `enddate`, `smoke_detector`, `wood`, `remarks_of_defects`, `forgotten`, `comments`) VALUES ('$koie', '$status', '$startdate', '$enddate', '$smoke', '$wood', '$impMissing', '$forgotten', '$comment'); ";
  
  if (!$mysqli->multi_query($double_query)) {
    echo "Multi query failed: (" . $mysqli->errno . ") " . $mysqli->error;
  }
  //videresende til ny side når skjema er fullført
  header("Location: success.html");
}

$mysqli->close();

?>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Koierapport</title>
    <link rel="icon" type="image/png" href="favicon.ico">

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="css/datepicker.css">
  </head>
  <body>
<div id="container">

<form class="form-horizontal" method="POST" onsubmit="return confirm('Er du sikker på at du vil sende rapporten?');">
<fieldset>

<!-- Form Name -->
<legend>Koierapport</legend>

<!-- Skriv inn epost-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email_input">Skriv inn epost</label>  
  <div class="col-md-3">
  <input id="email_input" name="email_input" type="text" placeholder="epost..." class="form-control input-md">
  <span id="user-result"></span>
  <span class="help-block">(Samme epost som du brukte da du reserverte koia.)</span>  
  </div>
</div>

<!-- Velg koie -->
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

<!-- Start dato -->
<div class="form-group">
  <label class="col-md-4 control-label" for="startdate">Dato - fra:</label>
  <div class="col-md-3">
    <input type='text' class="form-control" name="startdate" id="startdate" placeholder="Velg..." disabled />  
  </div>
</div>

<!-- Slutt dato -->
<div class="form-group">
  <label class="col-md-4 control-label" for="enddate">Dato - til:</label>
  <div class="col-md-3">
    <input type='text' class="form-control" name="enddate" id="enddate" placeholder="Velg..." disabled />  
  <span id="reservation-display"></span>
  </div>
</div>

<!-- Vedstokker -->
<div class="form-group">
  <label class="col-md-4 control-label" for="wood">Antall vedstokker ved koia </label>
  <div class="col-md-4"> 
    <label class="radio-inline" for="wood-0">
      <input type="radio" name="wood" id="wood-0" value="1">
      0-15
    </label> 
    <label class="radio-inline" for="wood-1">
      <input type="radio" name="wood" id="wood-1" value="2">
      15-30
    </label> 
    <label class="radio-inline" for="wood-2">
      <input type="radio" name="wood" id="wood-2" value="3" checked="checked">
      Mer enn 30
    </label>
  </div>
</div>

<!-- Røykvarsler -->
<div class="form-group">
  <label class="col-md-4 control-label" for="smoke">Virket røykvarsler?</label>
  <div class="col-md-4"> 
    <label class="radio-inline" for="smoke-0">
      <input type="radio" name="smoke" id="smoke-0" value="1" checked="checked">
      JA
    </label> 
    <label class="radio-inline" for="smoke-1">
      <input type="radio" name="smoke" id="smoke-1" value="0">
      NEI
    </label>
  </div>
</div>

<!-- Mangler -->
<div class="form-group">
  <label class="col-md-4 control-label" for="missing">Manglet noe?</label>
  <div class="col-md-4">
    <select id="missing" name="missing[]" class="form-control" multiple="multiple">
      <?php
      while($row = mysqli_fetch_array($inventory_list)) {
        echo "<option value=\"" . $row["utstyr"] . "\">" . $row["utstyr"] . "</option>\r\n";
      }
      ?>
    </select>
  </div>
</div>

<!-- Gjenglemt -->
<div class="form-group">
  <label class="col-md-4 control-label" for="smoke">Glemte dere noe?</label>
  <div class="col-md-4"> 
    <label class="radio-inline" for="forgotten-0">
      <input type="radio" name="forgotten" id="smoke-0" value="1">
      JA
    </label> 
    <label class="radio-inline" for="forgotten-1">
      <input type="radio" name="forgotten" id="smoke-1" value="0" checked="checked">
      NEI
    </label>
    <p class="help-block">Hvis JA, spesifiser i kommentarfeltet.</p>
  </div>
</div>

<!-- Kommentar -->
<div class="form-group">
  <label class="col-md-4 control-label" for="comment">Kommentar:</label>
  <div class="col-md-3">                     
    <textarea class="form-control" id="comment" name="comment" maxlength="800"></textarea>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4">
    <button type="submit" id="submit" name="submit" value="Submit" class="btn btn-primary" disabled>Send!</button>
  </div>
</div>

</fieldset>
</form>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-multiselect.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>
    <script src="js/inputcheck.js"></script>
        <script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                
                $('#startdate').datepicker({
                    format: "yyyy-mm-dd",
                    autoclose: true,
                    startDate: '-2w',
                    endDate: new Date()
                });

                $('#enddate').datepicker({
                    format: "yyyy-mm-dd",
                    autoclose: true,
                    startDate: '-2w',
                    endDate: new Date()

                });    
            
            });
        </script>
    <script type="text/javascript">
    $(document).ready(function() {  //få til autoclose
        $('#missing').multiselect({
            includeSelectAllOption: false,
            enableFiltering: false
        });

        $('#select_koie').multiselect({

        });
    });
</script>
</div>
  </body>
</html>