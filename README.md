
# Purpose of the system:
Budget and personal finance software

# Functional requirements:

### Accounts
The Accounts can be different types: income, outcome, mixed.
It’s a dictionary.
For example: job1, job2, bank_card1, bank_card2, deposit1, deposit2, clothing, housing, sport, foods, vehicle

### Ledgers
The ledger is operation of transition money from one Account to another also its have date and comment.
For example: 
-	user get salary, the ledger will be: job1 -> bank_card1 X
-	user buying sneakers, the ledger will be: bank_card1-> clothing X
-	user buying foods, the ledger will be: bank_card1-> foods X
-	user refueling a car, the ledger will be: bank_card1-> vehicle X
… and so on

### Account Personal Page
Some accounts have personal flag. Program calculates amount money on each Account Personal on current date (or chosen date). Program use Ledgers for calculations.
For example:
-	user can see money sums on bank_card1, bank_card2

### Account Personal Page Report
This mini report customizable by user summarizes and display some personal accounts.

### Report Months Totals
Calculates on each past months incomes\outcomes\delta\total of all personal accounts

### Report Income details
Calculates on each past month income by source
(+chart)
For example: job1, job2, income from deposit1

### Report Income details
Calculates on each past month outcome by destination
(+chart)
For example: clothing, housing, sport, foods, vehicle

# Use case:
- User customize accounts
- Put every operation in ledgers
- See reports and totals