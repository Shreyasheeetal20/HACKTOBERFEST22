# Test-Train Split

library(caTools)
#########################Test-Train Split#############################
#setting a seed
#set.seed(0)
split = sample.split(df,SplitRatio = 0.8)
train_set = subset(df,split==TRUE)
test_set = subset(df,split==FALSE)


#train.fit = glm(Sold~.,data = train_set,family = binomial)
#test.probs = predict(train.fit,test_set,type = "response")

#test.pred = rep("No",107)
#test.pred[test.probs>0.5] = "Yes"
#Confusion Matrix

#table(test.pred,test_set$Sold)
#######################################################################

library(class)
trainX = train_set[,-16]
testX = test_set[-16]

trainY = train_set$Sold
testY = test_set$Sold

k=3

# standardise=ing the variables
trainX_s = scale(trainX)
testX_s = scale(testX)
set.seed(0)

knn.pred = knn(trainX_s,testX_s,trainY,k=k)


#Confusion Matrix
table(knn.pred,testY)


# Comparasion of all 3 Classification Model
# Logistic Regression 65% accuracy
# KNN 55% accuracy on test data
# Decision tree 50.83 accuracy on test data

# When there is linear boundary then Logistic model performs well
# When there is non linear boundary KNN performs well


