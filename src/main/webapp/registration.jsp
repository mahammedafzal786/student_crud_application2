<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>
<link rel="stylesheet" type="text/css" href="registration.css">
</head>
<body>
		<h2>Student Registration Form</h2>
			<form action="InsertStudentServlet" method="POST">
    			<label for=" first_name ">First Name:</label>
    			<input type="text" id=" first_name " name=" first_name " required>
				
				<br>
				
    			<label for=" last_name ">Last Name:</label>
    			<input type="text" id=" last_name " name=" last_name " required>
    			
    			<br>

    			<label for="email">Email:</label>
    			<input type="email" id="email" name="email" required>
    			
    			<br>

    			<label for="phone">Phone Number:</label>
    			<input type="tel" id="phone" name="phone" required>
    			
    			<br>

  			  	<label for="dob">Date of Birth:</label>
    			<input type="date" id="dob" name="dob" required>
    			
    			<br>

    			<label>Gender:</label>
    			<input type="radio" id="male" name="gender" value="male" required>
    			<label for="male">Male</label>
    			<input type="radio" id="female" name="gender" value="female">
    			<label for="female">Female</label>
    			<input type="radio" id="other" name="gender" value="other">
    			<label for="other">Other</label>
    			
    			<br>

    			<label for="address">Address:</label>
    			<textarea id="address" name="address" rows="4" required></textarea>
    			
    			<br>

    			<label for="course">Select Course:</label>
    			<select id="course" name="course" required>
        		<option value="">--Please choose an option--</option>
        		<option value="bca">BCA</option>
        		<option value="bsc_it">B.Sc.IT</option>
        		<option value="msc_it">M.Sc.IT</option>
        		<option value="mba">MBA</option>
        		<option value="engineering">Engineering</option>
        		<option value="others">Others</option>
    			</select>
    			
    			<br>
    			
    			<label for="batch_time">Preferred Batch Time :</label>
    			<select id="batch_time" name="batch_time" required>
        		<option value="">--Please choose an option--</option>
        		<option value="morning">Morning</option>
        		<option value="afternoon">Afternoon</option>
        		<option value="evning">Evening</option>
    			</select>
    			
    			<br>
    			
    			<label>Payment Mode:</label>
    			<input type="radio" id="male" name="payment_mode" value="male" required>
    			<label for="credit_card">Credit Card</label>
    			<input type="radio" id="female" name="payment_mode" value="female">
    			<label for="debit_card">Debit Card</label>
    			<input type="radio" id="other" name="payment_mode" value="other">
    			<label for="net_banking">Net Banking</label>
    			
    			<br>
	
    			<label for="interests">Extracurricular Activities:</label>
    			<input type="checkbox" id="sports" name="interests" value="sports">
    			<label for="sports">Sports</label>
    			<input type="checkbox" id="music" name="interests" value="music">
    			<label for="music">Music</label>
   			 	<input type="checkbox" id="reading" name="interests" value="reading">
    			<label for="reading">Reading</label>
    			<input type="checkbox" id="traveling" name="interests" value="traveling">
    			<label for="traveling">Traveling</label>
    			
    			<br>
    			
    			<input type="submit" value="Register">
			</form>

</body>
</html>