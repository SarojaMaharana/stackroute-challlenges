## Problem Statement - Data Cleaning


Medical Insurance has become a part of the common man's life given the time of pandemic we are living in. The data that we have helps analysts allocate suitable policy to a valued customer.
Data cleaning is a major part before any analysis can be performed. Clean the data set and replace null values with appropriate values.

The dataset

- age: age of primary beneficiary

- sex: insurance contractor gender, female, male

- bmi: Body mass index, providing an understanding of body, weights that are relatively high or low relative to height,
objective index of body weight (kg / m ^ 2) using the ratio of height to weight, ideally 18.5 to 24.9

- children: Number of children covered by health insurance / Number of dependents

- smoker: Smoking

- region: the beneficiary's residential area in the US, northeast, southeast, southwest, northwest.

- charges: Individual medical costs billed by health insurance


Handle the null values appropriately using the Optional of Java 8

Objectives for the challenge.

1. The region value must not be null, if the value is null replace it with the most occurring value of the column
2. The age of the customer must not be zero, if so throw the exception appropriately