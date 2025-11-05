import pandas as pd

# Read the CSV file created in Activity17
df = pd.read_csv("user_data.csv")  # Make sure the CSV file is in the same folder

# 1. Print values only in the Usernames column
print("Usernames column:")
print(df["Usernames"])
print("\n")

# 2. Print the username and password of the second row
print("Second row data:")
print(df.iloc[1])  # iloc[1] gives the second row (indexing starts at 0)
print("\n")

# 3. Sort the Usernames column in ascending order and print data
print("Usernames sorted in ascending order:")
print(df.sort_values("Usernames"))
print("\n")

# 4. Sort the Passwords column in descending order and print data
print("Passwords sorted in descending order:")
print(df.sort_values("Passwords", ascending=False))
