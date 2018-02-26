<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX BANQUE</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<body>
	<div>
		<f:form modelAttribute="banqueForm" method="post"
			action="chargerCompte">
			<table>
				<tr>
					<td>Code</td>
					<td><f:input path="codeCompte" /></td>
					<td><f:errors path="codeCompte" cssClass="error" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="OK" /></td>
				</tr>
			</table>
		</f:form>
	</div>

	<c:if test="${not empty banqueForm.compte }">
		<div>
			<table>
				<tr>
					<td>Solde :</td>
					<td>${banqueForm.compte.solde }</td>
				</tr>

				<tr>
					<td>Date Création :</td>
					<td>${banqueForm.compte.dateCreation }</td>
				</tr>

				<tr>
					<td>Type Compte :</td>
					<td>${banqueForm.typeCompte }</td>
				</tr>
				<c:if test="${banqueForm.typeCompte=='CompteCourant' }">
					<tr>
						<td>Découvert :</td>
						<td>${banqueForm.compte.decouvert }</td>
					</tr>
				</c:if>
				<c:if test="${banqueForm.typeCompte=='CompteEpargne' }">
					<tr>
						<td>Taux :</td>
						<td>${banqueForm.compte.taux }</td>
					</tr>
				</c:if>
			</table>
		</div>

		<div>
			<f:form modelAttribute="banqueForm" action="saveOperation">
				<table>
					<f:hidden path="codeCompte" />
					<tr>
						<td><f:radiobutton path="typeOperation" value="VER"
								onclick="this.form.submit()" /></td>
						<td>Versement</td>
					</tr>
					<tr>
						<td><f:radiobutton path="typeOperation" value="RET"
								onclick="this.form.submit()" /></td>
						<td>Retrait</td>
					</tr>
					<tr>
						<td><f:radiobutton path="typeOperation" value="VIR"
								onclick="this.form.submit()" /></td>
						<td>Virement</td>
					</tr>
				</table>
				<c:if test="${not empty banqueForm.typeOperation }">
					<tr>
						<td>Montant</td>
						<td><f:input path="montant" /></td>
						<td><f:errors path="montant" cssClass="error" /></td>
					</tr>

					<c:if test="${banqueForm.typeOperation=='VIR' }">
						<tr>
							<td>Vers le compte</td>
							<td><f:input path="code2" /></td>
							<td><f:errors path="code2" cssClass="error" /></td>
						</tr>
					</c:if>
					<tr>
						<td><input type="submit" name="action" value="save"></td>
					</tr>
				</c:if>
			</f:form>
		</div>

		<div>
			<table>
				<tr>
					<td>Nom Client :</td>
					<td>${banqueForm.compte.client.nomClient }</td>
				<tr>
			</table>
		</div>
		<div>
			<table>
				<tr>
					<td>Nom Employer :</td>
					<td>${banqueForm.compte.employer.nomEmployer }</td>
				</tr>
			</table>
		</div>

		<div>
			<table class="table1">
				<tr>
					<th>Numéror</th>
					<th>Type Opération</th>
					<th>Date Opération</th>
					<th>Montant</th>
				</tr>

				<c:forEach items="${banqueForm.operations }" var="op">
					<tr>
						<td>${op.numOperation }</td>
						<td>${op }</td>
						<td>${op.dateOperation }</td>
						<td>${op.montant }</td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<c:forEach begin="0" end="${banqueForm.nbrePage-1 }" var="p">
					<c:choose>
						<c:when test="${p== banqueForm.page}">
							<span class="current">page ${p }</span>
						</c:when>
						<c:otherwise>
							<span class="autresPages"> <a
								href="chargerCompte?page=${p }&codeCompte=${banqueForm.codeCompte}">page
									${p }</a>
							</span>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
		</div>
	</c:if>

	<c:if test="${not empty banqueForm.erreurExeption }">
		<div class="error">${banqueForm.erreurExeption }</div>
	</c:if>
</body>
</html>