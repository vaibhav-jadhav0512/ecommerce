import { Button, Grid, Link, Typography } from "@mui/material";
import React from "react";

const Footer = () => {
  return (
    <div>
      <Grid
        className="bg-black text-white text-center mt-10"
        container
        sx={{ bgcolor: "black", color: "white", py: 3 }}
      >
        <Grid item xs={12} sm={6} md={3}>
          <Typography className="pb-5" variant="h6">
            Company
          </Typography>
          <div>
            <Button className="pb-5" variant="h6" gutterbottom="true">
              About
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6" gutterbottom="true">
              Blog
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6" gutterbottom="true">
              Careers
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6" gutterbottom="true">
              Partners
            </Button>
          </div>
        </Grid>
        <Grid item xs={12} sm={6} md={3}>
          <Typography className="pb-5" variant="h6">
            Solutions
          </Typography>
          <div>
            <Button className="pb-5" variant="h6" gutterbottom="true">
              Marketing
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6" gutterbottom="true">
              Analytics
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6" gutterbottom="true">
              Insights
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6" gutterbottom="true">
              Support
            </Button>
          </div>
        </Grid>
        <Grid item xs={12} sm={6} md={3}>
          <Typography className="pb-5" variant="h6">
            Documentation
          </Typography>
          <div>
            <Button className="pb-5" variant="h6" gutterbottom="true">
              Guides
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6" gutterbottom="true">
              API Status
            </Button>
          </div>
        </Grid>
        <Grid item xs={12} sm={6} md={3}>
          <Typography className="pb-5" variant="h6">
            Legal
          </Typography>
          <div>
            <Button className="pb-5" variant="h6" gutterbottom="true">
              Claim
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6" gutterbottom="true">
              Privacy
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6" gutterbottom="true">
              Terms
            </Button>
          </div>
        </Grid>
        <Grid className="pt-20" item xs={12}>
          <Typography variant="body2" component="p" align="center">
            &copy; 2023 ECommerce. All rights reserved.
          </Typography>
          <Typography variant="body2" component="p" align="center">
            Developed with &#10084; by Vaibhav Jadhav
          </Typography>
        </Grid>
      </Grid>
    </div>
  );
};

export default Footer;
