# For the given set of values LDA will calculate 
#the probablity of that observation belonging to 
#each group and which ever group has highest probablity 
#that group is assigned to that observation.

# LDA classifier
library(MASS)

lda.fit = lda(Sold~.,data = df)
lda.fit

lda.pred = predict(lda.fit,df)
# To look at the posterior probablity of the variables 
lda.pred$posterior
# By default the probablity condition is of 0.5
lda.class = lda.pred$class

# confusion matrix
table(lda.class,df$Sold)


# To change the boundary condition of the probablity on which the class are assigned
sum(lda.pred$posterior[,1]>0.8) # To give the count where the lda.pred$posterior variables 2nd column is > 0.8 

