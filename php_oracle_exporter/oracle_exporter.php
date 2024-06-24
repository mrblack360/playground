<?php

function getConfig() {
    return require 'config.php';
}

function executeQuery($query) {
    $config = getConfig();

    try {
        // Connect to Oracle database
        $conn = new PDO($config['dsn'], $config['username'], $config['password']);
        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        // Execute the query
        $stmt = $conn->prepare($query);
        $stmt->execute();

        // Fetch all results
        $results = $stmt->fetchAll(PDO::FETCH_ASSOC);

        // Export results to CSV
        exportToCSV($results);
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
}

function exportToCSV($data) {
    if (empty($data)) {
        echo "No results to export.";
        return;
    }

    // Create a file pointer
    $fp = fopen('php://output', 'w');

    // Set headers to download the file rather than display
    header('Content-Type: text/csv');
    header('Content-Disposition: attachment; filename="export.csv"');

    // Output the column headings
    fputcsv($fp, array_keys($data[0]));

    // Output the rows
    foreach ($data as $row) {
        fputcsv($fp, $row);
    }

    // Close the file pointer
    fclose($fp);
}

if ($argc < 2) {
    echo "Usage: php oracle_exporter.php 'your SQL query'\n";
    exit(1);
}

$query = $argv[1];
echo $query;
executeQuery($query);
?>
