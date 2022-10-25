if (!require(rpart)) install.packages('rpart')
library(rpart)
library(caTools)
set.seed(0)
split = sample.split(df,SplitRatio = 0.8)
train_set = subset(df,split==TRUE)
test_set = subset(df,split==FALSE)

trainX = train_set[,-16]
testX = test_set[-16]

trainY = train_set$Sold
testY = test_set$Sold


# standardise=ing the variables
trainX_s = scale(trainX)
testX_s = scale(testX)
set.seed(0)

tree1 <- rpart(Sold ~ ., data=train_set, method = 'class')
library(caret)
(varimp.tree1 <- varImp(tree1))
test_set$tree1.pred <- predict(tree1, newdata = test_set,type = 'class')
head(test_set[c("Sold","tree1.pred")], n=nrow(test_set))
(cm2 <- with(test_set,table(test_set$tree1.pred,test_set$Sold)))
View(test_set)

