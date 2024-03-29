<?php

// Setter status basert på gjenlemt og mangler input
function findStatus($missing, $forgotten) {
    $status = 0;
    if (count($missing) > 0) {
        $status = 2;
    } elseif ($forgotten == 1) {
        $status = 1;
    } else {
        $status = 0;
    }
    return $status;
}

// Sjekker om det er mangler og legger disse til i update query 
function createUpdate($columnArray, $koie, $wood, $smoke, $status, $forgotten) {
    if (count($columnArray) > 0) {
        foreach ($columnArray as $key => $value) {
          $pairs [] = "WHEN '$value' THEN 1";
        }
        $imploded = implode(' ', $pairs);

        return "UPDATE current_inventory2 SET " . $koie . "= CASE utstyr WHEN 'status' THEN " . $status . " " . $imploded . " WHEN 'wood' THEN " . $wood . " WHEN 'smoke' THEN " . $smoke . " WHEN 'forgotten' THEN " . $forgotten . " ELSE " . $koie . " END; ";
    }
    return "UPDATE current_inventory2 SET " . $koie . "= CASE utstyr WHEN 'status' THEN " . $status . " WHEN 'wood' THEN " . $wood . " WHEN 'smoke' THEN " . $smoke .  " WHEN 'forgotten' THEN " . $forgotten . " ELSE " . $koie . " END; ";
}

?>
