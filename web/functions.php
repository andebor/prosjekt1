<?php
function createUpdate($columnArray, $koie, $wood, $smoke) {
    foreach ($columnArray as $key => $value) {
      $pairs [] = "`$value` = '0'";
    }
    $imploded = implode(', ', $pairs);
    
    return "UPDATE current_inventory SET " . $imploded . ", `wood` = '" . $wood . "', `smoke` = '" . $smoke . "' WHERE koie = '$koie'";
}

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

?>