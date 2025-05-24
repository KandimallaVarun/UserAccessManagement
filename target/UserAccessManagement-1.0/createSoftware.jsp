<html><body>
<h2>Create Software</h2>
<form action='SoftwareServlet' method='post'>
  Name: <input type='text' name='name'/><br/>
  Description: <textarea name='description'></textarea><br/>
  Access Levels:<br/>
  <input type='checkbox' name='accessLevels' value='Read'/> Read
  <input type='checkbox' name='accessLevels' value='Write'/> Write
  <input type='checkbox' name='accessLevels' value='Admin'/> Admin<br/>
  <input type='submit' value='Create Software'/>
</form>
</body></html>
