import pandas as pd
import pymysql

# Read the CSV file into a pandas DataFrame
csv_file_path = '/mnt/data/nbaplayerdata.csv'
data = pd.read_csv(csv_file_path)

# Define database connection parameters
db_config = {
    'host': 'localhost',
    'user': 'your_username',     # replace with your MySQL username
    'password': 'your_password', # replace with your MySQL password
    'database': 'playerdb'
}

try:
    # Establish a database connection
    connection = pymysql.connect(**db_config)

    with connection.cursor() as cursor:
        print("Connected to MySQL database")

        # Create the player table if it doesn't exist
        create_table_query = """
        CREATE TABLE IF NOT EXISTS player (
            id INT PRIMARY KEY,
            first_name VARCHAR(50),
            last_name VARCHAR(50),
            team VARCHAR(50),
            position VARCHAR(50)
        );
        """
        cursor.execute(create_table_query)
        connection.commit()
        print("Table 'player' is ready.")

        # Insert data from DataFrame into the database
        for index, row in data.iterrows():
            # Check for missing or improperly formatted values
            if pd.notna(row['id']) and pd.notna(row['first_name']) and pd.notna(row['last_name']) and pd.notna(row['team']) and pd.notna(row['position']):
                try:
                    insert_query = """
                    INSERT INTO player (id, first_name, last_name, team, position)
                    VALUES (%s, %s, %s, %s, %s)
                    """
                    cursor.execute(insert_query, (int(row['id']), row['first_name'], row['last_name'], row['team'], row['position']))
                except ValueError as ve:
                    print(f"Skipping row {index} due to value error: {ve}")
                except Exception as e:
                    print(f"Skipping row {index} due to error: {e}")
            else:
                print(f"Skipping row {index} due to missing values.")

        connection.commit()
        print("Data inserted successfully into 'player' table.")

except Exception as e:
    print(f"Error: {e}")

finally:
    connection.close()
    print("MySQL connection is closed")
