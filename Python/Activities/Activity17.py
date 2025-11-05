import pandas as pd

# Create a dictionary with the data
data = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl13", "AllMight"]
}

# Convert the dictionary into a DataFrame
df = pd.DataFrame(data)

# Write the DataFrame to a CSV file
df.to_csv("user_data.csv", index=False)

print("Data has been written to 'user_data.csv'")
