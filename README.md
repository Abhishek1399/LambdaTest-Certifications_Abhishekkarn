Here in this script I used Java Framework . Use Lambda Test platform to run Selenium Automation Script to run on Selenium Grid . Use cross browser functinality . Test Scenario 1:

Test Scenario one - Passed

Open LambdaTest’s Selenium Playground from https://www.lambdatest.com/selenium-playground
Click “Simple Form Demo” under Input Forms.
Validate that the URL contains “simple-form-demo”.
Create a variable for a string value E.g: “Welcome to LambdaTest”.
Use this variable to enter values in the “Enter Message” text box.
Click “Get Checked Value”.
Validate whether the same text message is displayed in the right-hand panel under the “Your Message:” section.

Test Scenario Two - Failed Open the https://www.lambdatest.com/selenium-playground page and click “Drag & Drop Sliders” under “Progress Bars & Sliders”. 2. Select the slider “Default value 15” and drag the bar to make it 95 by validating whether the range value shows 95. Defect Raised - IN the Slide bar . No separate locators for the perticular slider.

Test Scenario Three - Passed Open the https://www.lambdatest.com/selenium-playground page and click “Input Form Submit” under “Input Forms”. 2. Click “Submit” without filling in any information in the form. 3. Assert “Please fill in the fields” error message. 4. Fill in Name, Email, and other fields. 5. From the Country drop-down, select “United States” using the text property. 6. Fill all fields and click “Submit”. 7. Once submitted, validate the success message “Thanks for contacting us, we will get back to you shortly.” on the screen.
