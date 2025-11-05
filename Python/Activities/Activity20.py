import pandas as pd

# Read the Excel file
df = pd.read_excel("contacts.xlsx")  # Make sure the file is in the same folder

# 1. Print the number of rows and columns
rows, columns = df.shape
print(f"Number of rows: {rows}")
print(f"Number of columns: {columns}\n")

# 2. Print the data in the Emails column only
print("Emails column data:")
print(df["Email"])
print("\n")

# 3. Sort the data based on FirstName in ascending order and print
print("Data sorted by FirstName in ascending order:")
print(df.sort_values("FirstName"))
