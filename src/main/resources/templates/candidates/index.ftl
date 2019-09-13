<h1>Candidate form</h1>

<form method="POST" action="/api/candidates">
  <label for="firstname">Firstname</label>
  <br>
  <input type="text" name="firstname" id="firstname">
  <br>
  <label for="lastname">Lastname</label>
  <br>
  <input type="text" name="lastname" id="lastname">
  <br>
  <label for="email">Email</label>
  <br>
  <input type="email" name="email" id="email">
  <br>
  <label for="cellPhone">Cell phone</label>
  <br>
  <input type="text" name="cellPhone" id="cellPhone">
  <br>
  <label for="homePhone">Home Phone</label>
  <br>
  <input type="text" name="homePhone" id="homePhone">
  <br>
  <label for="commentary">Commentary</label>
  <br>
  <textarea name="commentary" id="commentary"></textarea>
  <br>
  <label for="address">Address</label>
  <br>
  <input type="number" name="address" id="address">
  <br>
  <label for="ranking">Ranking</label>
  <br>
  <select name="ranking" id="ranking">
    <option value="RANK_0">0</option>
    <option value="RANK_1">1</option>
    <option value="RANK_2">2</option>
    <option value="RANK_3">3</option>
    <option value="RANK_4">4</option>
  </select>
  <br>
  <label for="feedback">Feedback</label>
  <br>
  <input type="number" name="feedback" id="feedback">
  <br>
  <label for="degrees">Degrees</label>
  <br>
  <input type="number" name="degrees" id="degrees">
  <br>
  <label for="matters">Matters</label>
  <br>
  <input type="number" name="matters" id="matters">
  <br>
  <label for="companySessions">Company and Sessions</label>
  <br>
  <input type="number" name="companySessions" id="companySessions">
  <br><br>
  <input type="submit" value="Submit">
</form>
