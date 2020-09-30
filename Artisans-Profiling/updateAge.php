<?php
		$con=new mysqli("localhost","root","","artisan-profiling");

		
		$a =$_GET["id"];
		$p = $_GET["age"];

		$st=$con->prepare("UPDATE `artisan` SET `age`=? WHERE `id`=?");
		$st->bind_param("ss", $p, $a);
		$st->execute();

		echo "data uploaded successfully!";
?>
