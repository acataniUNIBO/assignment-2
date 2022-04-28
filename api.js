const { exec } = require('child_process');

function getInterfaceReport(srcInterfacePath) {
    let promise = new Promise((resolve, reject) => {
        exec(`cd interfaceReport && ./gradlew run --args=" ${srcInterfacePath}"`, (error,stdout,stderr) => {
            if (error) {
                reject(error);
            }
            resolve(stdout);
        });
    });
    return promise;
}

function getClassReport(srcClassPath) {
    let promise = new Promise((resolve, reject) => {
        exec(`cd classReport && ./gradlew run --args=" ${srcClassPath}"`,(error,stdout,stderr) => {
            if (error) {
                reject(error);
            }
            resolve(stdout);
        });
    });
    return promise;
}

async function classReport(srcClassPath) {
    let res = await getClassReport(srcClassPath);
    console.log(res);
}
async function interfaceReport(srcInterfacePath) {
    let res = await getInterfaceReport(srcInterfacePath);
    console.log(res);
}

console.log("Class report: ");
classReport('/Users/andreacatani/Desktop/assignment-2-pcd/assignment-2/classReport/app/Car.java');
console.log("Interface Report: ");
interfaceReport('/Users/andreacatani/Desktop/assignment-2-pcd/assignment-2/interfaceReport/app/Car.java');

/*function getPackageReport(srcPackageFolderPath) {
    let promise = new Promise((resolve, reject) => {
        exec('',(error,stdout,stderr) => {
            if (error) {
                reject(error);
            }
            resolve(stdout);
        });
    });
    return promise;
}

function getProjectReport(srcProjectFolderPath) {
    let promise = new Promise((resolve, reject) => {
        exec('',(error,stdout,stderr) => {
            if (error) {
                reject(error);
            }
            resolve(stdout);
        });
    });
    return promise;
}




function analyzeProject_v_1(srcProjectFolderPath, callback) {
    let promise = new Promise((resolve, reject) => {
        exec('',(error,stdout,stderr) => {
            if (error) {
                reject(error);
            }
            let res = "";
            while(stdout) {
                res = stdout;
                callback(resolve(res));
                res = "";
            }
        });
    });
    return promise;
}*/