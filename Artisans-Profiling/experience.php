<?php
		$con=mysqli_connect("localhost","root","","artisan-profiling");
		$con1= new mysqli("localhost","root","","artisan-profiling");
		
		$ex = $_GET["experience"];
		$org = $_GET["orgmember"];
		$id=$_GET["id"];
		$artform=$_GET["artform"];
		//echo $artform;
		$st=$con1->prepare("UPDATE `artisan` set `experience`=? where `id`=?");
		$st->bind_param("ss", $ex, $id);
		$st->execute();
//echo ($org);
		$st1=$con1->prepare("UPDATE `extras` set `orgmember`=? where `artisanid`=?");
		$st1->bind_param("ss", $org, $id);
		$st1->execute();



		//$st2=$con->prepare("SELECT * FROM `artform` WHERE `artFormName`=? ");
		//$st2->bind_param("s", $artform);
		//$st2->execute();
		$query = "SELECT * FROM artform WHERE artFormName='$artform'";
		$result = mysqli_query($con,$query);
	//	echo $result;

		if (mysqli_num_rows($result) > 0) {
  // output data of each row
  while($row = mysqli_fetch_assoc($result)) {
  	$artformIdd=$row["id"];
//    echo "id: " . $row["id"];
  }
} else {
  echo "0 results";
}

$st2 = "INSERT INTO `artisanartformrelation` (artisanId, artFormId) VALUES('" . $id . "', '" . $artformIdd . "')";
		$result = mysqli_query($con, $st2) ;


		//echo "data uploaded successfully!";
		?>