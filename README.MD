# JDBC Integratie oefening
## Evaluatie
Punten worden gegeven op de volgende onderdelen:
- JDBC: Het correct toepassen van de geziene leerstof. Connections, Statements, you know the drill
- OOp en HC: Object Oriented principles en High Cohesion. Zorg ervoor dat je goed nadenkt over het toekennen van kerntaken aan je classes.
- Clean Code: Zorg voor propere code. (lees zeker de DOCC nog eens na)
- Bijkomende afspraken:
  - Gebruik engelse benamingen bij het kiezen van namen voor je variabelen en methoden
  - Probeer methodes niet langer te maken dan 1 schermlengte (geen gekantelde schermen en kleinere fonts gebruiken!!)
  - Planning en git: probeer een duidelijk overzicht te maken van de code/classes/functionaliteit die je moet programmeren. Deel deze op en maak een commit per deeltaak.

## Afspraken
Indienen via git en ten laatste op vrijdagavond 16h.
Feedback zal gegeven worden volgende week. We spreken hier nog een moment voor af.

## Opgave
Het bedrijf DakPlusPlus (D++) wilt in de nabije toekomst haar administratie naar de 21ste eeuw brengen. Momenteel werken ze met allerlei losse tools waaronder Excel, Word, een houten telraam en een witte tekkel genaamd Red Fluffy Satan.

Om dit project concreet te maken heeft D++ ons bedrijf ( Flatulent Factory Solutions ) ingehuurd samen met Smeghead Enterprises. Smeghead Enterprises is hoofdzakelijk een design firma en zal dan ook de UX of User Experience voor hun rekening nemen. Flatulent Factory Solutions is gespecialiseerd in backend solutions en zal dan ook de data- en service-layer schrijven. Jij bent de technical lead developer voor Flatulent Factory Solutions en aangezien de rest van het team ziek is sinds de laatste team barbecue ook de enige developer. Het is jou taak om het project volledig uit te schrijven.

Om te beginnen wil de firma graag een volledig beeld hebben van zijn personeel (naam, geboorteinformatie, data over hun contract bij de firma, loon, startdatum van huidig personeel en einddatum voor de ex-werknemers) en dit ook bijhouden in de nieuwe applicatie.

Anne van personeel is voorlopig tevreden met de basis functionaliteit, oplijsten van het personeel, nieuwe mensen kunnen toevoegen en gegevens van de huidige werknemers kunnen bewerken.

Smeghead Enterprises heeft al een deel van de frontend opgeleverd en het is jouw taak om hier een backend applicatie aan te linken. Het project is verdeeld in 2 "main" packages:
- dakplusbackend
- dakplusfrontend

In de package dakplusfrontend vind je de class Main. Deze kan je gebruiken om het programma op te starten. Het is de bedoeling dat je de code in deze package **onveranderd** laat.

In de package dakplusbackend vind je de klassen ServiceBinder en Configuration. ServiceBinder zal de backend aan de frontend linken, de configuratie hiervan vind je in de klasse Configuration.

```java
protected static void config(ServiceBinder binder) {
    binder.bind(EmployeeService.class, EmployeeServiceStub.class);
    binder.bind(ContractService.class, ContractServiceStub.class);
    binder.bind(WorkingDayService.class, WorkingDayServiceStub.class);
}
```

In bovenstaande code (2de lijn) wordt de EmployeeService interface gelinked aan de EmployeeServiceStub implementatie.

Wat jij als lead dev moet doen is je eigen implementatie van de backend schrijven en de EmployeeServiceStub vervangen in deze configuratie.

Bijvoorbeeld:
```java
  binder.bind(EmployeeService.class, EmployeeServiceImpl.class);
```

Maak hiervoor je eigen packages en klassen aan. In de dakplusbackend.service package kan je de nodige interfaces en hun documentatie terugvinden.
