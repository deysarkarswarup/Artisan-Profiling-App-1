<?php
		$con=new mysqli("localhost","root","","artisan-profiling");
		$artlearned=$_GET["artlearned"];
		$hascoworker = $_GET["hascoworker"];
		$noofcoworker = $_GET["noofcoworker"];
		$id = $_GET["id"];
		$st=$con->prepare("UPDATE `extras` set `artlearned`=? , `hascoworker`=? , `noofcoworker`=? where `artisanid`=?");
		$st->bind_param("ssss", $artlearned, $hascoworker, $noofcoworker, $id);
		$st->execute();
		echo "data uploaded successfully!";
		?>