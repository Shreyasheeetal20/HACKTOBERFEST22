# The Problem Statement is To find out the selling potential of the property based on the paramenters will need 
# to findout that the property will be sold in 3 months or not

df <- read.csv("HousePrice.csv",header = TRUE)
View(df)
str(df) # will give structure of df



# EDD (extended data dictionary)
summary(df)



# Graphs
boxplot(df$n_hot_rooms) # here can see outliers

pairs(~df$Sold+df$rainfall) # can see outlier

barplot(table(df$airport))
barplot(table(df$bus_ter))

#############Conslusion from graphs#############
# rainfall,n_hot_rooms have outliers
# bus_terminal variable is not of use as it dont make diffrence
# n_hos_beds as missing value
################################################



# Treating Outliers

uv<- 3*quantile(df$n_hot_rooms,0.99)
df$n_hot_rooms[df$n_hot_rooms>uv] <- uv

lv <- 0.3*quantile(df$rainfall,0.01)
df$rainfall[df$rainfall<lv] <- lv



# Treating NA values
which(is.na(df$n_hos_beds))

df$n_hos_beds[is.na(df$n_hos_beds)] <- mean(df$n_hos_beds,na.rm = TRUE)
mean(df$n_hos_beds)



# Variable transformation

df$avg_dist = (df$dist1+df$dist2+df$dist3+df$dist4)/4  # taking out the average and creating a column with it

tempdf <- df[,-6:-9]# df without column 6 to 9
df = tempdf
rm(tempdf) # remover temp variable

df <- df[,-13] # removing the not usefull columns of bus_ter



# catagorical variable handling
# Dummy Variable

#install.packages("dummies")
library(dummies)
df<- dummy.data.frame(df)
# removing the column with dummy variable as only one is needed from yes or no 

df<- df[,-8]
df<-df[,-13]

