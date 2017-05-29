<%--

 *
 * Copyright (C) 2016 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="shoppingGroup/user/editPunctuation.do?shoppingGroupId=${shoppingGroup.id }&oldValue=${oldValue}"
	modelAttribute="punctuation">
	
	
	<form:hidden path="id"/>
	<form:hidden path="version"/> 

	
	<form:label path="value">

		<spring:message code="punctuation.value"/>:

	</form:label>

	<form:select path="value">
	
		<option value ="-5">-5</option>
		
		<option value ="-4">-4</option>
		
		<option value ="-3">-3</option>
		
		<option value ="-2">-2</option>
		
		<option value ="-1">-1</option>

		<option value ="0">0</option>

		<option value ="1">1</option>

		<option value ="2">2</option>

		<option value ="3">3</option>

		<option value ="4">4</option>

		<option value ="5">5</option>

	

	</form:select>

	<form:errors cssClass="error" path="value"/>

	<br />
	
	

	<input type="submit" name="save"
		value="<spring:message code="punctuation.save" />" />&nbsp; 
	
	<input type="button" name="cancel"
		value="<spring:message code="punctuation.cancel" />"
		onclick="javascript: window.location.replace('shoppingGroup/user/display.do?shoppingGroupId=${shoppingGroup.id}');" />
	<br />

</form:form>





