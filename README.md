# 🧭 MakeMyTrip Calendar Automation

This automation script performs interaction with the MakeMyTrip website to select a departure date 5 days from today, including calendar handling and dynamic city dropdowns.

---

## 🔍 Scenario

- Open [MakeMyTrip](https://www.makemytrip.com/)
- Handle welcome/login pop-up
- Enter source and destination cities
- Select a departure date 5 days from today

---

## 🧪 Tech Stack

- Java 11  
- Selenium 4.33.0  
- XPath (for dynamic locators)  
- TestNG (can be added for assertions if extended)

---

## 🎥 Demo

![Demo GIF](MakeMyTripCalendarAutomation.gif)

---

## 📂 Project Structure

MakeMyTripCalendarAutomation

├── src/

│ └── main/

│ └── java/

│ └── com/

│ └── automation/

│ └── MakeMyTripCalendarAutomation.java

├── pom.xml

├── README.md

├── MakeMyTripCalendarAutomation.gif


---

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/NitishBahe/MakeMyTripCalendarAutomation.git
2. Open the project in an IDE like IntelliJ or Eclipse.
3. Make sure required dependencies are downloaded (pom.xml will handle it via Maven).
4. Run the MakeMyTripCalendarAutomation.java file.

---   

✅ Key Functional Steps

  1️⃣ Open MakeMyTrip and handle welcome/login pop-up

  2️⃣ Enter and select 'From' and 'To' cities from dropdowns

  3️⃣ Calculate and select the departure date 5 days from today

---

🌟 Key Highlights / Learnings

  1️⃣ Used WebDriver Wait with Combined Conditions
Handled dynamic dropdowns with a combination of visibility and size conditions:

  2️⃣ Dynamic Date Handling Using LocalDate Class
Used Java’s LocalDate class to calculate the date 5 days ahead.
  📌 Notes: LocalDate is immutable and thread-safe
  
  3️⃣ Dynamically Constructed XPath Using Axes
    a. Constructed calendar locators using XPath axes like ancestor, following-sibling, etc.
    b. Used chaining of WebElement to reliably select the right date
  
  4️⃣ Learned Git Workflow

---

🙌 Acknowledgment

  Thanks to Jatin Sharma for the guidance and knowledge shared throughout the process.




