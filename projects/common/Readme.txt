#Creating group MMZed-T21
sudo groupadd MMZed-T21

#Creating user postgre
sudo adduser postgre

#Adding user postgre to MMZed-T21 group
sudo adduser postgre MMZed-T21 

#Creating a new user on the fly for a specific software application in MMZed-T21 group
#Addidng user for postgresql
sudo useradd –G MMZed-T21 postgre 

#Change a Users Primary Group
sudo usermod –g group_name user_name

#Deleting user 
#Delete the user, without removing the user files
sudo deluser username

#Delete the user and its home directory and mail spool
sudo deluser --remove-home username

#Remove a user from a group
sudo gpasswd –d user_name group_name

#Deleting group
sudo groupdel group_name

#Installing postgresql 
#Importing the GPG repository key with the commands
sudo apt-get install wget ca-certificates
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -

#Adding the PostgreSQL repository 
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ `lsb_release -cs`-pgdg main" >> /etc/apt/sources.list.d/pgdg.list'

#Updating the package list
sudo apt-get update

#Install postgresql
sudo apt-get install postgresql postgresql-contrib

#Check version of postgresql
apt show postgresql


 
