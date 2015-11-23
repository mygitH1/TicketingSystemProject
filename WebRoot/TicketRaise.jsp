
<h2><center>Ticket Raise Form</center></h2>
<form method="post" action="raise">
<table>
<tr><td>IP Address</td><td><%=
 request.getRemoteAddr()%>
</td></tr>
<tr>
<td>Ticket No</td>
<td><%String tkt=%><%=com.ls.RandomInteger.showTicket()%><%; %>
<input type="text" value="<%=tkt%>" name="tno"/>
</td>
</tr>
<tr>
<td>Subject</td>
<td><select name="sub">
<option value="selected">--Select--</option>
<option value="monitor">monitor</option>
<option value="CPU">CPU</option>
<option value="software">software</option>
</select></td>
</tr>
<tr>
<td>Description</td>
<td><textarea rows="5" cols="12" name="desc"></textarea>
</tr>
<tr>
<td>Priority</td>
<td><select name="proir">
<option value="selected">--Select--</option>
<option value="high">high</option>
<option value="mediam">mediam</option>
<option value="low">low</option>
</select></td>
</tr>
<tr>
<td></td><td><input type="submit" name="send" value="send"/></td>
</tr>
</table>

</form>