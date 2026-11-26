# Test Plan: University Student Portal - Course Registration Module

## 1. Introduction

This plan describes how the Course Registration module of the University Student Portal will be tested. The module lets a logged-in student add and drop courses in a semester. This plan covers the Fall 2026 semester.

## 2. Objectives

- Check that a student can add a course that is open and has seats available.
- Check that a full course cannot be added.
- Check that a student cannot register for more than 6 courses in a semester.
- Check that the same course cannot be added twice.
- Check that a student can drop a registered course before the drop deadline, and cannot drop it after the deadline.

## 3. Scope

**In scope:** adding a course, full-course check, 6-course limit, duplicate
course check, dropping a course before the deadline, and the messages shown
for each of these.

**Out of scope:** login and password reset, fee payment, timetable clash checking, course prerequisites, performance testing.

## 4. Requirements to be Tested

| ID | Requirement |
|----|-------------|
| REQ-01 | A logged-in student can add a course that is open and has seats available |
| REQ-02 | The system does not allow adding a course that is full |
| REQ-03 | The system does not allow a student to register for more than 6 courses in a semester |
| REQ-04 | The system does not allow adding the same course twice |
| REQ-05 | A student can drop a registered course before the drop deadline |

## 5. Test Approach

- Manual testing using test cases written in a spreadsheet.
- Both positive and negative test cases will be written.
- Boundary testing for the 6-course limit (6th course allowed, 7th course rejected) and for the last available seat of a course.
- Every test case is linked to a requirement in the RTM sheet.

## 6. Test Environment

- Windows laptop with the latest Google Chrome.
- Test site of the Student Portal (not the live site).
- Test accounts (password for all: Pass@123), reset to the state below before each test case:

| Student ID | Starting state |
|------------|----------------|
| S1001 | No registered courses |
| S1002 | Registered in SE-301 only |
| S1003 | Registered in exactly 5 courses: SE-301, CS-101, CS-220, CS-230, SE-310 |
| S1004 | Registered in exactly 6 courses: SE-301, CS-101, CS-220, CS-230, SE-310, MATH-101 |

- Every test case starts with the student already logged in. Login itself is out of scope.


- Test courses:

| Course | Seats available | Status |
|--------|-----------------|--------|
| SE-301 | 10 | Open |
| SE-305 | 15 | Open |
| CS-101 | 20 | Open |
| CS-220 | 30 | Open |
| MATH-201 | 1 | Open |
| CS-210 | 0 | Full |
| CS-230 | 30 | Open |
| SE-310 | 30 | Open |
| MATH-101 | 30 | Open |

- Drop deadline for Fall 2026 on the test site: 10 September 2026. The test site date is set to 5 September 2026 for the "before deadline" test and 11 September 2026 for the "after deadline" test.


## 7. Roles

| Role | Name | Responsibility |
|------|------|----------------|
| Test Lead | Javeria Razzaq | Prepares the plan and reviews results |
| Tester | Javeria Razzaq | Writes and runs the test cases |

## 8. Schedule

| Activity | Day |
|----------|-----|
| Write test cases and RTM | Day 1 to 2 |
| Run the test cases | Day 3 to 4 |
| Report the results | Day 5 |

## 9. Entry and Exit Criteria

**Entry:** requirements approved, test site ready, test accounts and test courses created.

**Exit:** all test cases run, no open High priority defects, and every requirement has at least one test case.

## 10. Risks

| Risk | What we will do |
|------|-----------------|
| Requirements change | Update the test cases and the RTM |
| Test accounts or seat counts are changed by earlier tests | Reset the test data before each test case |
| Test site date cannot be changed for the drop-deadline tests | Ask the developers to set the date or the deadline on the test site |

## 11. Deliverables

Test plan, test cases, RTM and defect list.
