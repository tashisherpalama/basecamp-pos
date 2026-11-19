# Base Camp 1975 — Ordering & Billing System

A Java console app for taking orders and printing bills at **Base Camp 1975**, my family's restaurant in Thali, Kageshwori Manohara, Nepal.

I built it to speed up ordering and billing, and to practice object-oriented programming in Java.

## Features
- Menu grouped by category (Momos, Mains, Drinks)
- Take orders by table, with quantities
- Automatic bill with 10% service charge and 13% VAT
- End-of-day report: number of orders, total revenue, average order value and top 3 best-sellers
- Input validation, so wrong entries don't crash the program

## Example bill
```
----------------------------------------------
              BASE CAMP 1975
        Thali, Kageshwori Manohara
  Order #1                      Table 4
----------------------------------------------
  Chicken Momo (10 pcs)      x2   Rs   700.00
  Masala Tea                 x2   Rs   160.00
----------------------------------------------
  Subtotal                        Rs   860.00
  Service charge (10%)            Rs    86.00
  VAT (13%)                       Rs   122.98
  TOTAL                           Rs  1068.98
----------------------------------------------
```

## How it's built
| Class | What it does |
|---|---|
| `MenuItem` | One dish: id, name, category, price |
| `Menu` | Stores all items, finds items by number, prints the menu |
| `OrderLine` | One item on a bill and its quantity |
| `Order` | A table's order; calculates subtotal, service charge, VAT and total |
| `SalesReport` | End-of-day summary |
| `Main` | The menu-driven program you interact with |

## How to run
In Eclipse: import the project, open `Main.java`, and click Run.

From the command line:
```
javac -d out src/basecamp/*.java
java -cp out basecamp.Main
```

## What I'd add next
- Save orders to a file so sales are kept between days
- Discounts and split bills
- A simple graphical interface
