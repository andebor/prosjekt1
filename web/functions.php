<?php
// Sjekker om det er mangler og legger disse til i update query IKKE LENGER I BRUK!!
function createUpdate($columnArray, $koie, $wood, $smoke, $status) {
    if (count($columnArray) > 0) {
        foreach ($columnArray as $key => $value) {
          $pairs [] = "`$value` = '0'";
        }
        $imploded = implode(', ', $pairs);
        
        return "UPDATE current_inventory SET " . $imploded . ", `wood` = '" . $wood . "', `smoke` = '" . $smoke . "', `status`= '" . $status . "' WHERE koie = '" . $koie . "'";
    }
    return "UPDATE current_inventory SET `status`= '" . $status . "', `wood` = '" . $wood . "', `smoke` = '" . $smoke . "' WHERE koie = '" . $koie . "'";
}

// Setter status basert på gjenlemt og mangler input
function findStatus($missing, $forgotten) {
    $status = 0;
    if ($forgotten == 1) {
        $status = 2;
    } elseif (count($missing) > 0) {
        $status = 1;
    } else {
        $status = 0;
    }
    return $status;
}

// update for motsatt current inventory 
function createUpdate2($columnArray, $koie, $wood, $smoke, $status) {
    if (count($columnArray) > 0) {
        foreach ($columnArray as $key => $value) {
          $pairs [] = "WHEN '$value' THEN 0";
        }
        $imploded = implode(' ', $pairs);

        return "UPDATE current_inventory2 SET " . $koie . "= CASE utstyr WHEN 'status' THEN " . $status . " " . $imploded . " WHEN 'wood' THEN " . $wood . " WHEN 'smoke' THEN " . $smoke . " ELSE " . $koie . " END";
    }
    return "UPDATE current_inventory2 SET " . $koie . "= CASE utstyr WHEN 'status' THEN " . $status . " WHEN 'wood' THEN " . $wood . " WHEN 'smoke' THEN " . $smoke . " ELSE " . $koie . " END";
}

?>
