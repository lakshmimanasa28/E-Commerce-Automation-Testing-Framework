#  Design Document

## Framework Architecture

This framework follows the Page Object Model (POM) design pattern.

### Layers:

1. Test Layer → Contains TestNG test classes
2. Page Layer → Contains page-specific actions
3. Base Layer → Driver setup & teardown

---

##  Workflow Covered

* Login → Search → Add to Cart → Checkout

---

##  Key Components

### BaseTest

* Initializes WebDriver
* Handles browser setup and teardown

### Page Classes

* LoginPage
* ProductsPage
* CartPage
* CheckoutPage

---

##  Synchronization Strategy

* Explicit waits (WebDriverWait)
* Handling dynamic elements
* Popup handling

---

##  Challenges Faced

* Dynamic ads popup blocking search
* Flaky checkout flow
* Timing issues

---

##  Solutions

* Implemented popup handling method
* Added explicit waits
* Used JavaScriptExecutor where needed

---

##  Future Improvements

* Data-driven testing
* Cross-browser testing
* CI/CD integration (Jenkins)
